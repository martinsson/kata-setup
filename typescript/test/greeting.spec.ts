// tslint:disable-next-line:no-implicit-dependencies
import {expect} from 'chai';
import {greet} from "../src/greeting";

describe('greeting', () => {
  [
    ['joe', 'hello, joe.'],
    [undefined, 'hello, my friend.'],
    ['JERRY', 'HELLO JERRY !'],
  ].forEach(([name, expected]) => {
    it('should ', () => {
      expect(greet(name)).equal(expected);
    });
  });
  [
    [['mary', 'jane'], 'hello, mary and jane.'],
    [['mary', 'jane', 'charlotte'], 'hello, mary, jane and charlotte.'],
    [["Amy", "BRIAN", "Charlotte"], 'hello, Amy and Charlotte. AND HELLO BRIAN !'],
    [["Amy", "BRIAN, Charlotte"], 'hello, Amy and Charlotte. AND HELLO BRIAN !'],
    [["Amy", "\"BRIAN, Charlotte\""], 'hello, Amy and Charlotte. AND HELLO BRIAN !'],
  ].forEach(([names, expected]) => {
    it('should ', () => {
      expect(greet(...names)).equal(expected);
    });
  })

  it('should work for no names', () => {
    expect(greet()).equal("hello, my friend.")
  });

  it('greet', () => {
    expect(greet("joe")).equal('hello, joe.');
    expect(greet(undefined)).equal('hello, my friend.');
    expect(greet('JERRY')).equal('HELLO JERRY !');
    expect(greet('mary', 'jane')).equal('hello, mary and jane.')
    expect(greet('mary', 'jane', 'charlotte')).equal('hello, mary, jane and charlotte.')
  });

});
