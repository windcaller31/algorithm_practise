/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} t
 * @return {string}
 */
var tree2str = function(t) {
  if(t==null){
    return "";
  }
  var s = "";
  s = firstRootVisit(t,s);
  return s;
};

function firstRootVisit(node,s){
  if(s.length!=0){
    s+="(";
  }
  s += node.val;
  if(node.left!=null){
    s = firstRootVisit(node.left,s);
    s+=")";
  }else if(node.left == null&&node.right!=null){
    s+="()";
  }
  if(node.right!=null){
    s = firstRootVisit(node.right,s);
    s+=")";
  }
  return s;
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
var n1 = new TreeNode(1);
var n2 = new TreeNode(2);
var n3 = new TreeNode(3);
var n4 = new TreeNode(4);
n1.left = n2;
n1.right = n3;
n2.right = n4;
console.log(tree2str(n1));
