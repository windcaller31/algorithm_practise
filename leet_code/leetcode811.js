/**
 * @param {string[]} cpdomains
 * @return {string[]}
 */
var subdomainVisits = function(cpdomains) {
  var result = [];
  var domain_map = {};
  for(var i=0;i<=cpdomains.length-1;i++){
    var cpd = cpdomains[i];
    var url = cpd.split(" ")[1];
    var num = cpd.split(" ")[0];
    var dos = url.split(".");
    var this_dos = "";
    for(var j=dos.length-1; j>=0; j--){
      this_dos = dos[j] + this_dos;
      add_domains(this_dos,num,domain_map)
      if(this_dos!=0){
        this_dos = "." + this_dos;
      }
    }
  }
  for(key in domain_map){
    result.push( domain_map[key]+" "+key );
  }
  return result;
};

function add_domains(domains,domains_num,domain_map){
  if(domain_map[domains]){
    domain_map[domains] = Number(domains_num) + Number(domain_map[domains]);
  }else{
    domain_map[domains] = domains_num;
  }
}

console.log(JSON.stringify(subdomainVisits(["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"])));
