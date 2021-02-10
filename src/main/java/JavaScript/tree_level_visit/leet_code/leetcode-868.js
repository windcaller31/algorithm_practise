/**
 * @param {number} N
 * @return {number}
 */
var binaryGap = function(N) {
  var bin_array = [];
  var distance = 0;
  while(N!=0){
    bin_array.push(N%2)
    N = Math.floor(N/2);
  }
  console.log(bin_array);
  var num_of_one = 0;
  var num_of_zero = 0;
  var max_num_zero = 0;
  var first_one_flag = false;
  for( var i = 0; i<bin_array.length;i++ ){
    var b = bin_array[i];
    if(b==0&&first_one_flag){
      num_of_zero++;
    }
    if(b==1){
      if(!first_one_flag){
        first_one_flag = true;
      }
      num_of_one++;
      max_num_zero=Math.max(num_of_zero,max_num_zero);
      num_of_zero=0;
    }
  }
  if(num_of_one==0||num_of_one==1){
    return 0;
  }else{
    return max_num_zero+1;
  }

};

console.log(binaryGap(22));
