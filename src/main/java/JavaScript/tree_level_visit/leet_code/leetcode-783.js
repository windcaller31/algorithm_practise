function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

var minDiffInBST = function(root) {
  var num_array = [];
  get_num_array(root,num_array);
  var min;
  for(var i=1;i<=num_array.length-1;i++){
    var dex = num_array[i] - num_array[i-1];
    if((min==null)||(dex<min)){
      min=dex;
    }
  }
  return min;
};

function get_num_array(root,num_array){
  if(root.left!=null){
    get_num_array(root.left,num_array);
  }
  num_array.push(root.val);
  if(root.right!=null){
    get_num_array(root.right,num_array);
  }
}

var a1 = new TreeNode(4);
var a2 = new TreeNode(2);
var a3 = new TreeNode(6);
var a4 = new TreeNode(1);
var a5 = new TreeNode(3);
a1.left = a2;
a1.right = a3;
a2.left = a4;
a2.right = a5;

console.log(minDiffInBST(a1));
