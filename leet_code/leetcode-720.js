/**
 * @param {string[]} words
 * @return {string}
 */
var longestWord = function(words) {
  words = words.sort(function(a,b){
    if(b.length<a.length){
      return 1;
    }
    else if(b.length==a.length){
      if(b>a){
        return 1;
      }else{
        return -1;
      }
    }else if(b.length>a.length){
      return -1;
    }
  });
  console.log(words);
  var result = "";
  var dp = [];
  for(var i = 0; i<words.length; i++){
    var s = words[i];
    if(s.length==1){
      dp[i]=true;
      result = s;
    }else{
      for(var j=0;j<i;j++){
        if(dp[j]&&(s.length==words[j].length+1)&&s.startsWith(words[j])){
          dp[i] = true;
          result = s;
        }
      }
    }
  }
  return result;
};

console.log(longestWord(["aa","bb","bba","b","a"]));
// console.log(longestWord(["b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"]));
