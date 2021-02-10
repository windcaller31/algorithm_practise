/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} k
 * @return {boolean}
 */
var findTarget = function(root, k) {
  var a = [];
  get_array(root,a);
  var l = 0;
  var m = a.length-1;
  while(l<m){
    var sum = a[l] + a[m];
    if(sum<k){
      l++;
    }else if(sum>k){
      m--;
    }else{
      return true;
    }
  }
  return false;
};

function get_array(root,array){
  if(root.left!=null){
    get_array(root.left,array);
  }
  array.push(root.val);
  if(root.right!=null){
    get_array(root.right,array);
  }
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
