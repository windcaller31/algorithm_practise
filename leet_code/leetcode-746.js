/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
  var first_cost = 0;
  var total = [];
  total[0] = cost[0];
  total[1] = cost[1];
  for(var i = 2;i<=cost.length-1;i++){
    total[i] = Math.min(total[i-2]+cost[i],total[i-1]+cost[i]);
  }
  return Math.min(total[i-1],total[i-2]);
};
