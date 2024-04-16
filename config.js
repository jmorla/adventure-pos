import * as esbuild from 'esbuild';
import fs from 'fs';

const production = !process.argv[2]?.split(" ").find(e => e === '--watch')

function getDescrivedEntries() {
    const descriptor = JSON.parse(fs.readFileSync('target/classes/view_descriptor.json'));

    const entryPoints = [];
    for(let key in descriptor) {
        entryPoints.push("src/main/react/" + descriptor[key].entrypoint);
    }
    return entryPoints;
}

const config = {
    entryPoints: [...getDescrivedEntries()],
    bundle: true,
    outdir: "target/classes/static",
    loader: {
        '.png': 'dataurl',
        '.svg': 'text',
        '.woff2': 'dataurl',
        '.woff': 'dataurl'
    },
};

if(production) {
    await esbuild.build({
        ...config,
        minify: true,
    })

} else {
    const context = await esbuild.context({
        ...config,
    })

    await context.watch();
}