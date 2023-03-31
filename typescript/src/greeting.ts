export function greet(...names: string[]) {
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
  }
  const lastIndex = names.length - 1;
  const allButLast = names.slice(0, lastIndex);
  const last = names[lastIndex]
  return allButLast.join(', ') + " and " + last
}
