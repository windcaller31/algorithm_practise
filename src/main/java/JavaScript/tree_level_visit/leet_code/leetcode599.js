/**
 * @param {string[]} list1
 * @param {string[]} list2
 * @return {string[]}
 */
var findRestaurant = function(list1, list2) {
  var fav_1 = {};
  var fav_2 = {};
  for(var i =0;i<list1.length;i++){
    fav_1[list1[i]] = i;
  }
  for(var j=0;j<list2.length;j++){
    if(typeof(fav_1[list2[j]])!='undefined'){
      fav_2[list2[j]] = fav_1[list2[j]]+j;
    }
  }
  var result = [];
  var min = {};
  for(key in fav_2){
    if(typeof(min.min)=="undefined"){
      min.key = key
      min.min = fav_2[key];
    }if(min.min >= fav_2[key]){
      min.key = key
      min.min = fav_2[key];
    }
  }
  var minn = min.min;
  console.log(minn);
  for(key in fav_2){
    if( fav_2[key] == minn ){
      result.push(key);
    }
  }
  return result;
};

console.log(findRestaurant(["k","KFC"],["k","KFC"]));
