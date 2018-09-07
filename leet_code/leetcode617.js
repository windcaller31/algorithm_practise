/**
 * @param {TreeNode} t1
 * @param {TreeNode} t2
 * @return {TreeNode}
 */
var mergeTrees = function(t1, t2) {
  var node = new TreeNode(0);
  var return_node = contributeNewTree(t1,t2,node);
  return return_node;
};

function contributeNewTree(t1,t2,the_node){
    var v1 = 0;
    var v2 = 0;
    if(t1==null&&t2==null){
      return null;
    }
    if(t1==null){
      t1=new TreeNode(0);
    }
    if(t2==null){
      t2=new TreeNode(0);
    }
    v1 = t1.val;
    v2 = t2.val;
    the_node.val=v1+v2;
    var child_node_left = new TreeNode(0);
    var child_node_right = new TreeNode(0);
    the_node.left = contributeNewTree(t1.left,t2.left,child_node_left);
    the_node.right = contributeNewTree(t1.right,t2.right,child_node_right);
    return the_node;
}
