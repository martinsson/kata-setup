// tslint:disable-next-line:no-implicit-dependencies
import {assert, expect} from 'chai';

function greet(...names: string[]) {
  names = normalizeNames(names);

  const uppercaseNames = names.filter((n) => n.toUpperCase() === n)
  const lowercaseNames = names.filter((n) => n.toUpperCase() !== n)
  if (uppercaseNames.length > 0 && lowercaseNames.length > 0) {
    return `hello, ${formatNames(lowercaseNames)}` + ". AND " + `HELLO ${formatNames(uppercaseNames)}!`;
  }
  if (uppercaseNames.length > 0) {
    return `HELLO ${formatNames(uppercaseNames)}!`
  }
  return `hello, ${formatNames(lowercaseNames)}`;
}

function normalizeNames(names: string[]) {
  if (names.length === 1 && !names[0]) {
    names = ["my friend"]
  }

  const allNames = names
    .map((name) => name.replace(/"/g, ""))
    .map((value) => value.split(", "));
  return flatten(allNames)
}

function flatten(names: string[][]) {
  return names.reduce((acc, value) => acc.concat(...value), []);
}

function formatNames(names: string[]) {
  if (names.length > 1) {
    const last = names.splice(names.length - 1, 1);
    return names.join(', ') + " and " + last
  } else {
    return names[0]
  }
}


describe('greeting', () => {
  [
    ['joe', 'hello, joe'],
    [undefined, 'hello, my friend'],
    ['JERRY', 'HELLO JERRY!'],
  ].forEach(([name, expected]) => {
    it('should ', () => {
      expect(greet(name)).equal(expected);
    });
  });
  [
    [['mary', 'jane'], 'hello, mary and jane'],
    [['mary', 'jane', 'charlotte'], 'hello, mary, jane and charlotte'],
    [["Amy", "BRIAN", "Charlotte"], 'hello, Amy and Charlotte. AND HELLO BRIAN!'],
    [["Amy", "BRIAN, Charlotte"], 'hello, Amy and Charlotte. AND HELLO BRIAN!'],
    [["Amy", "\"BRIAN, Charlotte\""], 'hello, Amy and Charlotte. AND HELLO BRIAN!'],
  ].forEach(([names, expected]) => {
    it('should ', () => {
      expect(greet(...names)).equal(expected);
    });
  })

  it('greet', () => {
    expect(greet("joe")).equal('hello, joe');
    expect(greet(undefined)).equal('hello, my friend');
    expect(greet('JERRY')).equal('HELLO JERRY!');
    expect(greet('mary', 'jane')).equal('hello, mary and jane')
    expect(greet('mary', 'jane', 'charlotte')).equal('hello, mary, jane and charlotte')
  });

});
