/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */

function TreeNode(val){
  this.val = val;
  this.left = this.right = null;
}

var increasingBST = function(root) {
  var this_a = [];
  this_a = midOrderVisit(root,this_a);
  var number_one_element = this_a.shift();
  var number_one = new TreeNode(number_one_element);
  constructTree(this_a,number_one);
  return number_one;
};

function constructTree(node_array,last_node){
  if(node_array.length>0){
    var element = node_array.shift();
    var this_node = new TreeNode(element);
    last_node.right = this_node;
    constructTree(node_array,this_node)
  }else{
    return;
  }
}

function midOrderVisit(node,a){
  if(node.left!=null){
    a = midOrderVisit(node.left,a);
  }
  a.push(node.val);
  if(node.right!=null){
    a = midOrderVisit(node.right,a);
  }
  return a;
}

var r1 = new TreeNode(5);
var r2 = new TreeNode(2);
var r3 = new TreeNode(6);
var r4 = new TreeNode(4);
r1.left = r2;
r1.right = r3;
r2.right = r4
console.log(increasingBST(r1));
