# dots

> Connect the dots!

Dots is a tool that generates ClojureScript wrappers for JavaScript libraries
using their TypeScript definitions.  Usually, these are distributed
using `.d.ts` files -- hence the name.

You can find pre-built ClojureScript wrappers in the [dots-cljs]
GitHub organization.

[dots-cljs]: https://github.com/dots-cljs

## Installation

There is currently no pre-built distribution of dots, but you can clone this
repository.

## Building

Dots is a CLI program built with [Shadow CLJS][shadow-cljs].

Compile in release mode:

```
npm run release
```

This will create a JavaScript program `dist/dots.js` that you can run using NodeJS:

```
node dist/dots.js --help
```

## Usage

Dots uses the TypeScript compiler to analyse `.d.ts` files.  First you need to
install the type bindings of the library you wish to wrap using `npm` or `yarn`,
using a `package.json` file.

For example, this installs [`@types/node`][types-node], the TypeScript definitions
for Node's built-in libraries:

```
npm install @types/node
```

Then you can run `dots` to generate ClojureScript code.  To create wrappers for
the `path` module, run:

```
node path/to/dots.js path
```

By default, `dots` will create wrapper namespaces called `dots.<module>` and
write output files to `target/dots`.  You can override these defaults using
the `-n` and `-o` CLI options:

```
node path/to/dots.js -o ../dots-cljs/dots-node -n dots.node.path path
```

Run `node dist/dots.js --help` for more information.

[shadow-cljs]: https://github.com/thheller/shadow-cljs
[types-node]: https://www.npmjs.com/package/@types/node

## Development

Start a watch:

```
npm run watch
```

Run the program in REPL mode:

```
node dist/dots.js --repl
```

Now you can connect your IDE to the Shadow-CLJS REPL.


## License

Distributed under the [MIT License].  
Copyright &copy; 2024 [Ferdinand Beyer]

[Ferdinand Beyer]: https://fbeyer.com
[MIT License]: https://opensource.org/licenses/MIT
