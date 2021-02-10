var node = function(val){
  this.val = val;
  this.left;
  this.right;
}

function level_vist(root){
  var queue = [];
  var result = [];
  var last = root;
  var nlast ;
  if(root == null){
    return result;
  }else{
    queue.unshift(root);
  }
  while(queue.length!=0){
    var tmp = queue.pop();
    if(tmp==null){
      continue;
    }
    result.push(tmp.val);
    if(tmp.left!=null){
      nlast = tmp.left;
      queue.unshift(tmp.left);
    }
    if(tmp.right!=null){
      nlast = tmp.right;
      queue.unshift(tmp.right);
    }
    if(last == tmp){
      last = nlast;
      result.push("#!");
    }
  }
  var final_result = [];
  var mid_result = [];
  for(var j=0;j<result.length;j++){
    if(result[j]!="#!"){
      mid_result.push(result[j]);
    }else{
      final_result.push(mid_result);
      mid_result = [];
    }
  }
  return final_result;
}

var n1 = new node(1);
var n2 = new node(2);
var n3 = new node(3);
var n4 = new node(4);
var n5 = new node(5);
var n6 = new node(6);
n1.left = n2;
n2.right = n3;
n2.left = n4;
n3.left = n5;
n3.right = n6;
console.log(level_vist(n1));
