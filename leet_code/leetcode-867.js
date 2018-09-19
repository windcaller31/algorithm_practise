/**
 * @param {number[][]} A
 * @return {number[][]}
 */
var transpose = function(A) {
  var B = [];
  var row_len = A.length;
  var col_len = A[0].length;
  for(var i =0;i<col_len;i++){
    if(!B[i]){
      B[i] = [];
    }
    for(var j = 0;j<row_len;j++){
      B[i][j] = A[j][i];
    }
  }
  return B;
};
