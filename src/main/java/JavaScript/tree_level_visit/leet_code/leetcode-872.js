/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {boolean}
 */
var leafSimilar = function(root1, root2) {
  var node_array_1 = getLeafArray(root1);
  var node_array_2 = getLeafArray(root2);
  console.log(node_array_1,node_array_2);
  for(var i in node_array_1){
    if(node_array_1[i]!=node_array_2[i]){
      return false;
    }
  }
  return true;
};

function getLeafArray(n){
  var node_array = [];
  if(n.left!=null){
    node_array = node_array.concat(getLeafArray(n.left));
  }
  if(n.right!=null){
    node_array = node_array.concat(getLeafArray(n.right));
  }
  if(n.left==null&&n.right==null){
    node_array.push(n.val);
  }
  return node_array;
}


function TreeNode(val) {
     this.val = val;
     this.left = this.right = null;
}
var r1 = new TreeNode(1);
var r1_1 = new TreeNode(3);
r1.left = r1_1;
var r2 = new TreeNode(2);
var r2_1 = new TreeNode(2);
r2.left = r2_1;
console.log(leafSimilar(r1,r2));
