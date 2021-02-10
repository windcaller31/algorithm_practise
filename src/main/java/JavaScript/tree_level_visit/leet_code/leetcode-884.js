/**
 * @param {string} A
 * @param {string} B
 * @return {string[]}
 */
var uncommonFromSentences = function(A, B) {
  var MapA = {};
  var MapB = {};
  A = A.split(" ");
  B = B.split(" ");
  var result = {};
  for(var i in A){
    result[A[i]] = (result[A[i]]||0)+1;
  }
  for(var i in B){
    result[B[i]] = (result[B[i]]||0)+1;
  }
  var rs = [];
  for(var key in result){
    if(result[key]==1){
      rs.push(key);
    }
  }
  return rs;
};
