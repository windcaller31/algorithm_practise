var sortArrayByParity = function(A) {
  var l = 0;
  var r = A.length-1;
  var tmp = A[l];
  while(l<r){
    while((l<r)&&(A[r]%2==1)){
      r--;
    }
    A[l] = A[r]
    while((l<r)&&(A[l]%2==0)){
      l++;
    }
    A[r] = A[l];
  }
  A[l] = tmp;
  return A
};
