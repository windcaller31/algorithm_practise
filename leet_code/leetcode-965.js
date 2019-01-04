/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isUnivalTree = function(root) {
    var q = [];
    if(root==null){
      return true;
    }
    q.push(root);
    var result = [];
    while(q.length!=0){
      var node = q.shift();
      result.push(node.val);
      if(result.length>=2){
        if(result[result.length-1]!=result[result.length-2]){
          return false;
        }
      }
      if(node.left!=null){
        q.push(node.left);
      }
      if(node.right!=null){
        q.push(node.right);
      }
    }
    return true;
};

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var n1 = new TreeNode(1);
var n2 = new TreeNode(1);
var n3 = new TreeNode(1);
n1.left=n2;
n1.right=n3;

console.log(isUnivalTree(n1));
