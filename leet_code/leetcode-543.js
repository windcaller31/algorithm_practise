/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */

var diameterOfBinaryTree = function(root) {
  if(root==null){
    return 0 ;
  }
  this.max = 0;
  this.help = function(root){
    if(root==null){
      return 0;
    }
    var left = this.help(root.left,max);
    var right = this.help(root.right,max);
    this.max = Math.max(this.max,left+right);
    return Math.max(left,right)+1;
  }
  this.help(root);
  return this.max;
};


function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var n = new TreeNode(0);
n.left = new TreeNode(1);
n.right = new TreeNode(2);
console.log(diameterOfBinaryTree(n));
