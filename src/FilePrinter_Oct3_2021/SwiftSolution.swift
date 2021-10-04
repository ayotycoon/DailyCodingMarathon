import Foundation

class Node {

    let val : String

    var children  = [String: Node]()

    init(_ val : String){
        self.val = val
    }

    func printNode(){
        print("\(val)")
        for i  in children.keys{
            print(i)
        }
    }
    
}

func printFilePath(_ arr : [String]) -> String{

    // create path 
    var root = Node("root")

    for file in arr{
        var currNode = root

         let strs = file.components(separatedBy: "/")
          for s in strs{
            if currNode.children[s] == nil{
                currNode.children[s] = Node(s)  
            }   
            if let val = currNode.children[s]{
                currNode = val
            }
        }
    }

    

    var name = ""
    func printValue(_ tab :  String, _ node: Node){
        for child in node.children.values{
            name.append("\(tab)--\(child.val)")
            name.append("\n")
            printValue("\t\(tab)", child)
        }
    }

    printValue("", root)
    return name
}

var paths =  [
"app/documents/person",
"She.png",
"She/She.png",
"app/documents/rude"
]

let m = printFilePath(paths)

print(m)
