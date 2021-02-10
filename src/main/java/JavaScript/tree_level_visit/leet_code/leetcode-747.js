/**
 * @param {number[]} nums
 * @return {number}
 */
var dominantIndex = function(nums) {
  if(nums.length==0){
    return -1;
  }
  var max = nums[0];
  var index = 0;
  for(var i=0;i<nums.length;i++){
    if(nums[i]>max){
      max = nums[i];
      index = i;
    }
  }
  for(var i=0;i<nums.length;i++){
    if(max<nums[i]*2&&i!=index){
      return -1;
    }
  }
  return index;
};

console.log(dominantIndex([0,0,0,1]));
