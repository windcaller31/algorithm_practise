/**
 * @param {string} S
 * @return {number[]}
 */
var diStringMatch = function(S) {
  var len = S.length;
  var array = [];
  for(var i=0;i<=len;i++){
    array.push(i);
  }
  S = S.split("");
  var result = [];
  for(var j=0;j<S.length;j++){
    var str = S[j];
    if(str=="I"){
      result.push(array.shift());
    }
    if(str=="D"){
      result.push(array.pop());
    }
  }
  result.push(array.pop());
  return result;
};

console.log(diStringMatch("IDID"));
