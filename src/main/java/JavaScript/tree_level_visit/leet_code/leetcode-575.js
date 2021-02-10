/**
 * @param {number[]} candies
 * @return {number}
 */
var distributeCandies = function(candies) {
  var kinds = {};
  for(key in candies){
    var ck = candies[key];
    if(kinds[ck]){
      kinds[ck] = 1
    }else{
      kinds[ck] = kinds[ck]+1;
    }
  }
  var kinds_num = Object.keys(kinds).length;
  var kinds_2_num = Math.round(candies.length/2);
  return kinds_num>=kinds_2_num?kinds_2_num:kinds_num;
};

console.log(distributeCandies([1,1,2,2,3,3]));
