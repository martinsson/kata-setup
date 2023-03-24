// tslint:disable-next-line:no-implicit-dependencies
import {assert, expect} from 'chai';

function greet(...names: string[]) {

  const name = names[0]
  if (names.length === 3) {
    const guests = names[0] + ", " + names[1] + " and " + names[2]
    return `hello, ${guests}`
  }
  if (names.length === 2) {
    const guests = names[0] + " and " + names[1]
    return `hello, ${guests}`
  }
  const s = name || "my friend";
  if (s.toUpperCase() === s) {
    return `HELLO ${s}!`
  }
  return `hello, ${s}`;
}

describe('greeting', () => {
  [
    ['joe', 'hello, joe'],
    [undefined, 'hello, my friend'],
    ['JERRY', 'HELLO JERRY!']
  ].forEach(([name, expected]) => {
    it('should ', () => {
      expect(greet(name)).equal(expected);
    });
  });
  [
    [['mary', 'jane'], 'hello, mary and jane'],
    [['mary', 'jane', 'charlotte'], 'hello, mary, jane and charlotte'],
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
