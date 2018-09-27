/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
  if(root == null){
    return null;
  }
  var stack = [];
  stack = rootSerialize(root,stack);
  return stack.join("^");
};

var rootSerialize = function(root,s){
  s.push(root.val);
  if(root.left!=null){
    s = rootSerialize(root.left,s);
  }
  if(root.right!=null){
    s = rootSerialize(root.right,s);
  }
  return s;
}

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
  if(data==null||data==""){
    return null;
  }
  data = data.split("^");
  var newData = [];
  for(key in data){
    newData.push(Number(data[key]))
  }
  return rootDeserialize(newData);
};

var rootDeserialize = function(que){
  if(que.length==0){
    return null
  }
  var value = que.shift();
  var newNode = new TreeNode(Number(value));
  var newQue = [];
  while(que[0]<value&&que.length>0){
    newQue.push(que.shift());
  }
  newNode.left = rootDeserialize(newQue);
  newNode.right = rootDeserialize(que);
  return newNode ;
}

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var n1 = new TreeNode(3);
var n2 = new TreeNode(1);
var n3 = new TreeNode(4);
var n4 = new TreeNode(2);
n1.left = n2;
n1.right = n3;
n2.right = n4;

console.log(JSON.stringify(n1));
console.log(JSON.stringify(deserialize(serialize(n1))));
