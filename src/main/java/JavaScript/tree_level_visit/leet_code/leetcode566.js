/**
 * @param {number[][]} nums
 * @param {number} r
 * @param {number} c
 * @return {number[][]}
 */
var matrixReshape = function(nums, r, c) {
  var row_num = nums.length;
  var col_num = nums[0].length;
  if(row_num*col_num<r*c){
    return nums;
  }
  var mid_r = [];
  for(var i=0;i<=nums.length-1;i++){
    var this_col = nums[i];
    for(var j=0;j<=this_col.length-1;j++){
      mid_r.push(this_col[j]);
    }
  }
  console.log(mid_r);
  var result = [];
  for(var k=0;k<=r-1;k++){
    var t_r = [];
    for(var l=0;l<=c-1;l++){
      t_r.push(mid_r.shift());
    }
    result.push(t_r);
  }
  return result;
};

matrixReshape([[1,2],[3,4]],2,4);
