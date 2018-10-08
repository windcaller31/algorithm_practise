/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  var the_start = 0;
  var the_end = nums.length-1;
  return midSearch(nums,the_start,the_end,target);
};

var midSearch = function(nums,start,end,target){
  var mid = Math.round((start+end)/2);
  if(start>end){
    return -1;
  }
  if(target==nums[mid]){
    return mid;
  }
  if(target>nums[mid]){
    return midSearch(nums,mid+1,end,target);
  }
  if(target<nums[mid]){
    return midSearch(nums,start,mid-1,target);
  }
};

console.log(search([2,5],2));
