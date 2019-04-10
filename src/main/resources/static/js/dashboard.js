function refreshDashboard(data) {
  var data = [80, 10, 10];

  var diskValues = axios.get('http://localhost:8090/actuator/health')
    .then( (response) => {
      //console.log(response);
      diskValues = Object.values(response.data.details.diskSpace.details);
      diskKeys = Object.keys(response.data.details.diskSpace.details);

      var ctx = document.getElementById("mem-widget").getContext('2d');
      var myChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
          labels: diskKeys,
          datasets: [{
            backgroundColor: [
              "#2ecc71",
              "#3498db",
              "#95a5a6",
              "#9b59b6",
              "#f1c40f",
              "#e74c3c",
              "#34495e"
            ],
            data: diskValues
          }]
        }
      }); 

    })
    .catch(function (error) {
      console.log(error);
    }); 
}