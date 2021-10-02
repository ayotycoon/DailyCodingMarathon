class Solution {
    func lengthLongestPath(_ input: String) -> Int {
        let paths = input.components(separatedBy : "\n")
        //["dir", "\tsubdir1", "\tsubdir2", "\t\tfile.ext"]
        
        var q = [Int: Int]()
        //print(paths[3].components(separatedBy: "\t"))
        var maxLen = 0
        
        for str in paths{
            
            let c = str.components(separatedBy: "\t")
            let chars = c[c.count-1]
            
            var cSum = 0
            
            if let val = q[c.count-1]{
                cSum = val
            }
            
            let value = chars.count + cSum + 1
            
            if chars.contains("."){
                maxLen = max(value, maxLen)
            }else{
                q[c.count] = value
            }
            print(q)
        }

        
        return maxLen == 0 ? 0 :  maxLen - 1
    }
}