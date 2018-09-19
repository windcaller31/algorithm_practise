/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} val
 * @return {TreeNode}
 */

var searchBST = function(root, val) {
  var node = search_value(root,val);
  if(node == null){
    return [];
  }
  return node;
};

function search_value(root,value){
  var node = null;
  if(root==null){
    return node;
  }
  if(root.val==value){
    return root;
  }else if(root.val>value){
    node = search_value(root.left,value);
  }else if(root.val<value){
    node = search_value(root.right,value);
  }
  return node;
}

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}
