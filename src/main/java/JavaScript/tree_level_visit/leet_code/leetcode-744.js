/**
 * @param {character[]} letters
 * @param {character} target
 * @return {character}
 */
var nextGreatestLetter = function(letters, target) {
  var min;
  var j = 0;
  while(j<letters.length){
    if(letters[j]>target&&(min==null||letters[j]<min)){
      min =letters[j];
    }
    j++;
  }
  if(typeof(min)=="undefined"){
    return letters[0];
  }
  return min;
};

console.log(nextGreatestLetter(["c","f","j"],"d"));
