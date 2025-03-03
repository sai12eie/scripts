Running the typescript example:
* Open tsconfig.json and change outDir so that it points to <sahipro>/userdata/scripts/sahitests/typescript/out folder
 "outDir": "<sahipro>/userdata/scripts/sahitests/typescript/out"
* Open the typescript folder in MS Code and build (Tasks -> Run Build Task -> tsc:build)
OR Open a command prompt, cd to typescript and run "tsc"
This will create the <sahipro>/userdata/scripts/sahitests/typescript/out folder
* In Sahi Editor, open cart_execute.js and Playback.

Points to note:
* We can keep typescript files anywhere. We just need to provide the compiled js files to Sahi Pro.
* The custom ts files need to invoke Sahi's APIs. These are specified in sahi_apis.ts file.
* The logs in Sahi point to the lines of script of the compiled js file.


