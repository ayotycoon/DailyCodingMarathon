class LRUCache {

    var dict  : [Int : Node]
    let c : Int
    var root = Node(-1, -1)
    var tail = Node(-2, -2)
    
    init(_ capacity: Int) {
        self.dict = [Int: Node]()
        self.c = capacity
        root.next = tail
        tail.prev = root
    }
   // 1->2->3->4
    func get(_ key: Int) -> Int {
        if let node = dict[key]{
            //update linked list 
            deleteNode(node)
            update(node)
            return dict[node.key]!.value
        }else{
            return -1
        }
    }
    
    func put(_ key: Int, _ value: Int) {
        // if it exist
        if let node = dict[key]{
            node.value = value
            deleteNode(node)
            dict[key] = node
            update(node)
        }else{
            if dict.count == c{
                dict.removeValue(forKey:tail.prev!.key)
                deleteNode(tail.prev!)
            }
            dict[key]  = Node(key, value)
           update(dict[key]!) 
        }
        print(root.next?.key, tail.prev?.key)
    }

    func update(_ node: Node){
        let oldHead = root.next
        root.next = node
        node.prev = root
        oldHead?.prev = node
        node.next = oldHead
        
    }
        
    func deleteNode(_ node: Node){
        let prev = node.prev
        prev?.next = node.next
        node.next?.prev = prev
    }
}
//1->2->3

class Node{
    let key : Int //key
    var value: Int
    var prev : Node?
    var next : Node?
    
    init(_ key : Int, _ value: Int){
        self.key = key
        self.value = value
    }
}

//dictionary : [key : val]
//get lookup dictionary at constant time
//make the key the head the linkedlist 
//put value in a dictionary : 
// make the value I put or update the head of the linkedList 
// {1: 1, 2: 2}   2->1
// make the value of the recently used the head of the linkedlist 
//make get if  2->4->3->1
//temp = 2
/**
 * Your LRUCache object will be instantiated and called as such:
 * let obj = LRUCache(capacity)
 * let ret_1: Int = obj.get(key)
 * obj.put(key, value)
 */