<script setup>
import { RouterLink, RouterView } from 'vue-router'

</script>

<template>
  <body>
    <header>
      <div>
        <nav>
          <RouterLink to="/">포켓몬리스트</RouterLink>
          <RouterLink to="/post">추가하기</RouterLink>
        </nav>
      </div>
    </header>
    <section>
    <RouterView />
    </section>
  </body>
</template>

<style scoped>
@font-face {
    font-family: 'PyeongChangPeace-Bold';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2206-02@1.0/PyeongChangPeace-Bold.woff2') format('woff2');
    font-weight: 700;
    font-style: normal;
}

body {
  min-height: 100dvh;
  background-color: #8F8681;
  overflow: hidden;
}

header{
  width: 100%;
  height: 80px;
  display: flex;
  flex-direction: row;
  align-items: center;
  background-color: #32435F;
  box-shadow: 0 10px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
}

header > div {
  width: 100%;
}

nav {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}

a{
  font-family: 'PyeongChangPeace-Bold';
  margin-left: 30px;
  margin-right: 30px;
  font-size: 1.6em;
  color: #E1DCD9;
  text-decoration-line: none;
}

section {
  padding: 30px;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>