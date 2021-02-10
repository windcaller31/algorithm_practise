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
var findSecondMinimumValue = function(root) {
  var old_results = {};
  find(root,old_results);
  var results = [];
  for(key in old_results){
    results.push(key);
  }
  results.sort(function(a,b){
    return Number(a)-Number(b);
  });
  if(Number(results[0])==Number(results[results.length-1])){
    return -1;
  }
  // var r = Number(results[results.length-1]);
  // for(var i=results.length-1;i>=0;i--){
  //   if(r!=Number(results[i])){
  //     r = Number(results[i]);
  //     break;
  //   }
  // }
  return Number(results[1]);
};

function find(root,results){
  if(root!=null){
    find(root.left,results)
    find(root.right,results)
    results[root.val] = 1;
  }
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var root = new TreeNode(5);
root.left = new TreeNode(5);
root.right = new TreeNode(6);
console.log(findSecondMinimumValue(root));
