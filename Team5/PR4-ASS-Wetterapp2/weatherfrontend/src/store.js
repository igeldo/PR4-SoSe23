import { createStore } from 'vuex';

export default createStore({
    state: {
        timezone: '',
        timezoneOffset: 0,
    },
    mutations: {
        SET_TIMEZONE(state, timezone) {
            state.timezone = timezone;
        },
        SET_TIMEZONE_OFFSET(state, offset) {
            state.timezoneOffset = offset;
        },
    },
});
