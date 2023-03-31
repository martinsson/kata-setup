
export function greet(...names: string[]) {
  const normalizedNames = normalizeNames(names);

  const normalNames = joinNames(normalizedNames.filter((n) => n.toUpperCase() !== n))
  const shoutingNames = joinNames(normalizedNames.filter((n) => n.toUpperCase() === n))

  if (normalNames && shoutingNames) {
    return sayHelloTo(normalNames) + " AND " + shoutHelloTo(shoutingNames);
  }
  return normalNames ? sayHelloTo(normalNames) : shoutHelloTo(shoutingNames);
}

function normalizeNames(rawNames: string[]) {
  const inputIsEmpty = rawNames.length === 0 || !rawNames[0];
  if (inputIsEmpty) {
    rawNames = ["my friend"]
  }

  const csvEscapeCharacters = /"/g;
  const csvSeparator = ", ";
  const allNames = rawNames
    .map((name) => name.replace(csvEscapeCharacters, ""))
    .map((value) => value.split(csvSeparator));

  return flatten(allNames)
}

function flatten(names: string[][]) {
  return names.reduce((acc, value) => acc.concat(...value), []);
}

function joinNames(names: string[]) {
  if (names.length <= 1) {
    return names[0]
  }
  const lastIndex = names.length - 1;
  const allButLast = names.slice(0, lastIndex);
  const last = names[lastIndex]
  return allButLast.join(', ') + " and " + last
}

function sayHelloTo(normalNames: string) {
  return `hello, ${normalNames}.`;
}

function shoutHelloTo(shoutingNames: string) {
  return `HELLO ${shoutingNames} !`;
}
