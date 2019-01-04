/**
 * @param {number[]} A
 * @return {number[]}
 */
var sortArrayByParityII = function(A) {
  var danshu = [];
  var shuangshu = [];
  for(var i = 0;i<A.length;i++){
    var a = A[i];
    if(a%2==0){
      shuangshu.push(a);
    }else{
      danshu.push(a);
    }
  }
  var result = [];
  for(var j=0;j<A.length;j++){
    if(j%2==0){
      result.push(shuangshu.pop());
    }else{
      result.push(danshu.pop());
    }
  }
  return result;
};
