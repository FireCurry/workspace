const serviceKey = "dZKmt6uLu%2Fb2KPn9P6DWxYguHvqc%2F86%2BzSl2CtQYwSWCN%2BUAjmJpSLYp6On2r9XKp%2FleP1Sk%2BkecXO77E4g3vg%3D%3D";

const getAirPollution = () => {

const requestUrl = 'http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty';

// 쿼리 스트링 생성 (URLSearchParams.toString())

const searchParams = new URLSearchParams();

searchParams.append('returnType', 'JSON');
searchParams.append('serviceKey', serviceKey);
searchParams.append('sidoName', "서울");

fetch(requestUrl + "?" + searchParams.toString())

.then(resp => resp.json())

.then(result => {

console.log(result);

})

.catch(e => console.log(e));

}

getAirPollution();