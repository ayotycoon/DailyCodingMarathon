 func flipEquiv(_ root1: TreeNode?, _ root2: TreeNode?) -> Bool {
        if root1 == nil && root2 == nil{
            return true
        }
        if  root1 == nil || root2 == nil || root1!.val != root2!.val{
            return false
        }
        
        return flipEquiv(root1?.left, root2?.left) && flipEquiv(root1?.right, root2?.right) || flipEquiv(root1?.left, root2?.right) && flipEquiv(root1?.right, root2?.left)
    }