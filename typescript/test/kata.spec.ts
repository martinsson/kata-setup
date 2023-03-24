// tslint:disable-next-line:no-implicit-dependencies
import {assert, expect} from 'chai';

function greet(...names: string[]) {
  names = normalizeNames(names);

  const shoutingNames = formatNames(names.filter((n) => n.toUpperCase() === n))
  const normalNames = formatNames(names.filter((n) => n.toUpperCase() !== n))
  if (normalNames && shoutingNames) {
    return `hello, ${normalNames}` + ". AND " + `HELLO ${shoutingNames}!`;
  }
  if (normalNames) {
    return `hello, ${normalNames}`;
  }
  return `HELLO ${shoutingNames}!`
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
  if (names.length <= 1) {
    return names[0]
  } else {
    const last = names.splice(names.length - 1, 1);
    return names.join(', ') + " and " + last
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
