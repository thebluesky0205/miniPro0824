<template>
  <v-app id="inspire">
    <v-app-bar
      app
      clipped-right
      color="blue"
      dark
    >
      <v-toolbar-title><div @click="home">날씨 테스트 페이지.</div></v-toolbar-title>
      <v-spacer></v-spacer>
      <slot name="menubar"></slot>
    </v-app-bar>

    <v-container>
      <v-content id="content">
        <slot name="content" class="font">
        </slot>
      </v-content>
    </v-container>
  </v-app>
</template>

<script>
// import router from '../router'

export default {
  data: () => ({
    drawer: false,
    left: false
  }),
  methods: {
  }
}
</script>
