/**
 * @param {string[]} ops
 * @return {number}
 */
var calPoints = function(ops) {
  var result = [];
  for(var i=0;i<=ops.length-1;i++){
    var op = ops[i];
    if(op == "+"){
      var r = getjia(result);
      result.push(r);
    }else if(op == "D"){
      var r = getd(result);
      result.push(r);
    }else if(op == "C"){
      getc(result);
    }else{
      result.push(Number(op));
    }
  }
  var sum = 0;
  for(key in result){
    sum += Number(result[key]);
  }
  return sum;
};

function getjia(sum_array){
  var sum = 0;
  for(var k = sum_array.length-1; k>=sum_array.length-2;k--){
    sum += Number(sum_array[k]);
  }
  return sum;
}

function getc(sum_array){
  sum_array.pop();
}

function getd(sum_array){
  var sum = Number(sum_array[sum_array.length-1])*2;
  return sum;
}

console.log(calPoints(["5","-2","4","C","D","9","+","+"]));
