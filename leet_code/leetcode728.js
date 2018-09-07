var selfDividingNumbers = function(left, right){
  var return_array=[];
  for(var i=left;i<=right;i++){
    if(judgeDivding(i)){
      return_array.push(i);
    }
  }
  return return_array;
};

function judgeDivding(num){
  var num_string = num.toString();
  num_string = num_string.split("");
  for(var key in num_string){
    if(num%Number(num_string[key]) != 0){
      return false;
    }
  }
  return true;
}
