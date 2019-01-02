/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} sum
 * @return {number}
 */
var pathSum = function(root, sum) {
  if(root==null){
    return 0;
  }
  var res = findSum(root,0,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
  return res;
};

function findSum(node,curSum,sum){
  if(node==null){
    return 0;
  }
  curSum += node.val;
  if(curSum == sum){
    return 1+findSum(node.left,curSum,sum)+findSum(node.right,curSum,sum);
  }else{
    return findSum(node.left,curSum,sum)+findSum(node.right,curSum,sum);
  }
}

function TreeNode(val) {
     this.val = val;
     this.left = this.right = null;
}

var n1 = new TreeNode(1);
var n2 = new TreeNode(-2);
var n3 = new TreeNode(-3);
var n4 = new TreeNode(1);
var n5 = new TreeNode(3);
var n6 = new TreeNode(-2);
var n8 = new TreeNode(-1);
[1,-2,-3,1,3,-2,null,-1]
n1.left = n2;
n1.right = n3;
n2.left = n4;
n2.right = n5;
n3.left = n6
n4.left = n8;
console.log(n1);
console.log(pathSum(n1,-1));
