/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
var isToeplitzMatrix = function(matrix) {
  var flag = true;
  var row_num = matrix.length;
  var col_num = matrix[0].length;
  for(var i = 0; i<=row_num-1; i++){
    for(var j=0; j<=col_num-1; j++){
      var r = matrix[i][j];
      var r_i = i;
      var r_j = j;
      while((r_i+1<=row_num-1)&&(r_j+1<=col_num-1)){
        r_i++;
        r_j++;
        if(r!=matrix[r_i][r_j]){
          flag = false;
          break;
        }
      }
    }
  }
  return flag;
};


console.log(isToeplitzMatrix([[36,59,71,15,26,82,87],[56,36,59,71,15,26,82],[15,0,36,59,71,15,26]]));
