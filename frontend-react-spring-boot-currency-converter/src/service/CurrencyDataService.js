import axios from 'axios';

const CURRENCY_API_URL = 'http://localhost:7777'
const GET_CURRENCIES_API_URL = '/api/currencies' 


class CurrencyDataService{
    retrieveAllCurrencies(){
        return axios.get(`${CURRENCY_API_URL}${GET_CURRENCIES_API_URL}`);
    }
}

export default new CurrencyDataService();