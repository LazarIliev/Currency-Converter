import axios from 'axios';
import AuthenticationService from './AuthenticationService';

const CURRENCY_API_URL = 'http://localhost:7777'
const GET_CURRENCIES_API_URL = '/api/currencies' 


class CurrencyDataService{
    retrieveAllCurrencies(){
        return axios.get(`${CURRENCY_API_URL}${GET_CURRENCIES_API_URL}`);
    }

    convertCurrency(fromCurrencyCode, toCurrencyCode, amount){
        return axios.get(`${CURRENCY_API_URL}/api/convert?codeFrom=${fromCurrencyCode}&codeTo=${toCurrencyCode}&amount=${amount}`);
    }

    addCurrency(code, name, rate, ratio){
        this.isAuthenticated();
        return axios.post(`${CURRENCY_API_URL}/api/add`,{code, name, rate, ratio})
    }

    deleteCurrency(code){
        this.isAuthenticated();
        return axios.delete(`${CURRENCY_API_URL}/api/currency/${code}`)
    }

    isAuthenticated(){
        if(AuthenticationService.isUserLoggedIn()){
            const token = sessionStorage.getItem("authorization");
            AuthenticationService.setupAxiosInterceptors(token);
        }
    }
}

export default new CurrencyDataService();