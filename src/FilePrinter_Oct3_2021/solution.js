

const _input = [
    "app/documents/rude",
    "app/documents/person",
    "She/She.png",
    "She.png",

]


const tabPrinter = (n) => {

    let t = "";
    for (let i = 0; i < n; i++) {
        t+="\t";

    }

    return t;

}

const hash = {};


const solve = (inputs) => {

    inputs.forEach(str => {
        const splits = str.split('/');

        let prev = ''
        splits.forEach(fileOrPath => {


            const isFile = !!fileOrPath.match(/\./);
            if(!isFile){
                const path = prev ? (prev + '/' + fileOrPath) : fileOrPath;
                const existsInMap = hash[path] != undefined;
                let index = 0;

                if(hash[path] != undefined){
                    index = hash[path]
                }else if(hash[prev]  != undefined){
                    index = hash[prev] +1
                }



                if(!existsInMap){
                    console.log(tabPrinter(index) + ("—" + fileOrPath))
                }

                hash[path] = index;

                prev = path;
            } else {

                const index = hash[prev] != undefined ? hash[prev] + 1 : 0
                console.log(tabPrinter(index) + ("—" + fileOrPath))

            }


        })

    })


}

solve(_input)

