<template>
    <div id="app">
        <div class="weather-app">
            <Weather />
        </div>
    </div>
</template>

<script>
import Weather from './components/Weather.vue';

export default {
    name: 'App',
    components: {
        Weather
    }
}
</script>

<style>
#app {
    display: flex;
    align-items: center;
    justify-content: center;
    min-height: 100vh;
}

.weather-app {
    max-width: 500px;
    width: 100%;
    padding: 20px;
    background-color: #fff;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}
</style>
