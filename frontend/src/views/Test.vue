<template>
  <Layout>
    <template #menubar>
      <v-btn @click="start()" text color="black"
        style="padding: 10px; width: 90px;">새로고침</v-btn>
    </template>
    <template #content>
      <v-simple-table>
        <template v-slot:default>
          <thead>
            <tr>
              <th class="text-left">No</th>
            </tr>
          </thead>
          <tbody>
          <h3>....</h3>
            <tr v-for="list of lists" :key="list.title">
              <td style="color: gray">{{ list.weatherNo }}</td>
              <td><a @click="clickWeather(list.weatherNo)">{{ list.day }}</a></td>
            </tr>
          </tbody>
        </template>
      </v-simple-table>
    </template>
  </Layout>
</template>

<script>
import Layout from '../components/Layout'
import { mapState } from 'vuex'

export default {
  components: { Layout },
  computed: {
    ...mapState({
      lists: state => state.lists
    })
  },
  methods: {
    clickWeather (weatherNo) {
      console.log('clickWeather: ' + weatherNo)
      this.$store.dispatch('crawlFindOne', weatherNo)
    },
    start () {
      this.$store.dispatch('crawlFind')
    }
  }
}
</script>
